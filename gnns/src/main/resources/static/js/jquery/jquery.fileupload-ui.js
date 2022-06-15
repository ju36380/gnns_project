/*
 * jQuery File Upload User Interface Plugin 1.1
 *
 * Copyright 2010, Sebastian Tschan, AQUANTUM
 * Licensed under the MIT license:
 * http://creativecommons.org/licenses/MIT/
 *
 * https://blueimp.net
 * http://www.aquantum.de
 */

/*jslint browser: true */
/*global jQuery */

(function ($) {

    var UploadHandler = function (dropZone, options) {
        if (!options.uploadTable) {
            $.error('jQuery.fileUploadUI requires option uploadTable: $(uploadTable)');
        }
        if (!options.downloadTable) {
            $.error('jQuery.fileUploadUI requires option downloadTable: $(downloadTable)');
        }
        if (typeof options.buildUploadRow !== 'function') {
            $.error('jQuery.fileUploadUI requires option buildUploadRow: function (files, index) {return $(row)}');
        }
        if (typeof options.buildDownloadRow !== 'function') {
            $.error('jQuery.fileUploadUI requires option buildDownloadRow: function (json) {return $(row)}');
        }
        
        var uploadHandler = this,
            dragLeaveTimeout,
            isDropZoneEnlarged,
            normalizeFiles = function (files) {
                var file, i;
                for (i = 0; i < files.length; i += 1) {
                    file = files[i];
                    if (typeof file === 'string') {
                        files[i] = {name: file, type: null, size: null};
                    }
                }                
                return files;
            };
        
        this.progressSelector = '.file_upload_progress div';
        this.cancelSelector = '.file_upload_cancel div';
        this.cssClassSmall = 'file_upload_small';
        this.cssClassLarge = 'file_upload_large';
        this.cssClassHighlight = 'file_upload_highlight';
        this.dropEffect = 'highlight';
        
        this.init = function (files, index, xhr, callBack) {
            files = normalizeFiles(files);
            
            var uploadRow = uploadHandler.buildUploadRow(files, index),
                progressbar,
                callBackSettings;
            
            var filter = filename;
    		filter = filter.slice(filter.lastIndexOf(".")+1).toLowerCase();
    		/*
    		if(filter != "jpg" && filter !="png" && filter !="jpeg" && filter !="bmp" && filter !="gif" 
    			&& filter !="txt" &&filter != "hwp" && filter !="xls" && filter !="xlsx" && filter !="doc" 
    				&& filter !="ppt" && filter !="pptx" && filter !="zip" && filter !="pdf" && filter !="rar"){		    			
    			
    			alert('[jpg, png, jpeg, bmp, gif, txt, hwp, xls, xlsx, doc, ppt, pptx, pdf]외의 확장자는 등록할 수 없습니다.');		    			
    			return; 		    			
    		}
            */
            if (uploadRow) {
                progressbar = uploadRow.find(uploadHandler.progressSelector).progressbar({
                    value: (xhr ? 0 : 100)
                });
                uploadRow.find(uploadHandler.cancelSelector).click(function () {
                    if (xhr) {
                        xhr.abort();
                    } else {
                        // javascript:false as iframe src prevents warning popups on HTTPS in IE6
                        // concat is used here to prevent the "Script URL" JSLint error:
                        dropZone.find('iframe').attr('src', 'javascript'.concat(':false;'));
                        uploadRow.fadeOut(function () {
                            $(this).remove();
                        });
                    }
                });
                uploadRow.appendTo(uploadHandler.uploadTable).fadeIn();
            }
            callBackSettings = {uploadRow: uploadRow, progressbar: progressbar};
            if (typeof uploadHandler.initCallBack === 'function') {
                uploadHandler.initCallBack(files, index, xhr, function (settings) {
                    callBack($.extend(settings, callBackSettings));
                }, callBackSettings);
            } else {
                callBack(callBackSettings);
            }
        };
        
        this.abort = function (event, files, index, xhr, settings) {
            if (settings.uploadRow) {
                settings.uploadRow.fadeOut(function () {
                    $(this).remove();
                });
            }
        };
        
        this.progress = function (event, files, index, xhr, settings) {
            if (settings.progressbar) {
                settings.progressbar.progressbar(
                    'value',
                    parseInt(event.loaded / event.total * 100, 10)
                );
            }
        };
        
        this.load = function (event, files, index, xhr, settings) {
            if (settings.uploadRow) {
                settings.uploadRow.fadeOut(function () {
                    $(this).remove();
                });
            }
            try {
            	var evantData=event.target.responseText;
            	
            	if(event.target.responseText==undefined){
            		evantData=$(event.target).contents().text();
            	}            	

            	console.log("before eval");
            	eval("var jsonObj = "+evantData);
            	
            	console.log("jsonObj.isError=" + jsonObj.isError);
                if(jsonObj.isError == undefined){
            		if(jsonObj.nullsession){
            			location.href = "/cmm/error/eniaSessionError.do";
                    }
            	}
                var json, downloadRow;  
                if (jsonObj) {
                	
                	//첨부파일 exception 처리
                	if(jsonObj.JsonResVO[1].getRes == 'Exception'){
                		alert(jsonObj.JsonResVO[1].getResMsg);
                		return;
                	}
                	
                	if(jsonObj.JsonResVO[0].getResMsg != ''){
                		alert(jsonObj.JsonResVO[0].getResMsg);
                 		return;
                	}

                	if(jsonObj.JsonResVO[4] != undefined){ // 법인기본정보 첨부파일관리 (기본재산, 정관변경)
                		if(jsonObj.JsonResVO[4].getResMsg == 'tab3'){
                			if(parseInt(jsonObj.JsonResVO[2].getResMsg) > 94371840){
                        		alert('첨부파일 용량이 90MB를 초과할 수 없습니다.');
                        		filedelete(jsonObj.JsonResVO[3].getResMsg,false);
                        		return;
                        	}
                    
                        	filecnt_tab3++;
                        	filetotal_tab3 += parseInt(jsonObj.JsonResVO[2].getResMsg);
                        	$("#filetotal_tab3").html(AddComma(filetotal_tab3) + " byte");
                        	downloadRow = uploadHandler.buildDownloadRow(jsonObj.JsonResVO[1].getResMsg,jsonObj.JsonResVO[2].getResMsg,jsonObj.JsonResVO[3].getResMsg,jsonObj.JsonResVO[5].getResMsg);
                            if (downloadRow) {
                                downloadRow.appendTo(uploadHandler.downloadTable).fadeIn();
                            }
                		}else if(jsonObj.JsonResVO[4].getResMsg == 'tab5'){
                			if(parseInt(jsonObj.JsonResVO[2].getResMsg) > 94371840){
                        		alert('첨부파일 용량이 90MB를 초과할 수 없습니다.');
                        		filedelete(jsonObj.JsonResVO[3].getResMsg,false);
                        		return;
                        	}
                    
                        	filecnt_tab5++;
                        	filetotal_tab5 += parseInt(jsonObj.JsonResVO[2].getResMsg);
                        	$("#filetotal_tab5").html(AddComma(filetotal_tab5) + " byte");
                        	downloadRow = uploadHandler.buildDownloadRow(jsonObj.JsonResVO[1].getResMsg,jsonObj.JsonResVO[2].getResMsg,jsonObj.JsonResVO[3].getResMsg,jsonObj.JsonResVO[5].getResMsg);
                            if (downloadRow) {
                                downloadRow.appendTo(uploadHandler.downloadTable).fadeIn();
                            }
                            /** 경로당 ****
                             * 0 성공유무
                             * 1 ecm
                             * 2 파일명원본명
                             * 3 용량 
                             * 4 파일명
                             * 5 구분값
                             * */
                		}else if(jsonObj.JsonResVO[5] !=null && jsonObj.JsonResVO[5].getResMsg == "1"){   				// 경로당 외부사진  기존 파일배열과 순서와 갯수가다름.//
                			if(parseInt(jsonObj.JsonResVO[3].getResMsg) > 94371840){
                        		alert('첨부파일 용량이 90MB를 초과할 수 없습니다.');
                        		filedelete(jsonObj.JsonResVO[3].getResMsg,false);
                        		return;
                        	}
                    
                        	filecnt++;
                        	filetotal +=  parseInt(jsonObj.JsonResVO[3].getResMsg);
                        	$("#filetotal").html(AddComma(filetotal) + " byte");
                        	downloadRow = uploadHandler.buildDownloadRow(jsonObj.JsonResVO[2].getResMsg,jsonObj.JsonResVO[3].getResMsg,jsonObj.JsonResVO[4].getResMsg);
                            if (downloadRow) {
                                downloadRow.appendTo(uploadHandler.downloadTable).fadeIn();
                            }
                		}else if(jsonObj.JsonResVO[5] !=null && jsonObj.JsonResVO[5].getResMsg == "2"){				// 경로당 외부사진  기존 파일배열과 순서와 갯수가다름.//
                			if(parseInt(jsonObj.JsonResVO[3].getResMsg) > 94371840){
                        		alert('첨부파일 용량이 90MB를 초과할 수 없습니다.');
                        		filedelete(jsonObj.JsonResVO[3].getResMsg,false);
                        		return;
                        	}
                    
                        	filecnt2++;
                        	filetotal2 +=  parseInt(jsonObj.JsonResVO[3].getResMsg);
                        	$("#filetotal2").html(AddComma(filetotal2) + " byte");
                        	downloadRow = uploadHandler.buildDownloadRow(jsonObj.JsonResVO[2].getResMsg,jsonObj.JsonResVO[3].getResMsg,jsonObj.JsonResVO[4].getResMsg);
                            if (downloadRow) {
                                downloadRow.appendTo(uploadHandler.downloadTable).fadeIn();
                            }
                		}else if(jsonObj.JsonResVO[5] !=null && jsonObj.JsonResVO[5].getResMsg == "Or"){				// 경로당 외부사진  기존 파일배열과 순서와 갯수가다름.//
                			if(parseInt(jsonObj.JsonResVO[3].getResMsg) > 94371840){
                        		alert('첨부파일 용량이 90MB를 초과할 수 없습니다.');
                        		filedelete(jsonObj.JsonResVO[4].getResMsg,false);
                        		return;
                        	}
                    
                        	filecntOr++;
                        	filetotalOr +=  parseInt(jsonObj.JsonResVO[3].getResMsg);
                        	$("#filetotalOr").html(AddComma(filetotalOr) + " byte");
                        	downloadRow = uploadHandler.buildDownloadRow(jsonObj.JsonResVO[2].getResMsg,jsonObj.JsonResVO[3].getResMsg,jsonObj.JsonResVO[4].getResMsg);
                            if (downloadRow) {
                                downloadRow.appendTo(uploadHandler.downloadTable).fadeIn();
                            }
                		}else if(jsonObj.JsonResVO[4].getResMsg == "comm"){
                			//소통방 파일 사이즈업 실제 120MB,화면상 100MB 125,829,120
                			if(parseInt(jsonObj.JsonResVO[2].getResMsg) > 94371840){
                				alert('첨부파일 용량이 90MB를 초과할 수 없습니다.');
                				filedelete(jsonObj.JsonResVO[3].getResMsg,false);
                				return;
                			}
                			
                			filecnt++;
                			filetotal += parseInt(jsonObj.JsonResVO[2].getResMsg);
                			$("#filetotal").html(AddComma(filetotal) + " byte");
                			downloadRow = uploadHandler.buildDownloadRow(jsonObj.JsonResVO[1].getResMsg,jsonObj.JsonResVO[2].getResMsg,jsonObj.JsonResVO[3].getResMsg);
                			if (downloadRow) {
                				downloadRow.appendTo(uploadHandler.downloadTable).fadeIn();
                			}
                		}else if(jsonObj.JsonResVO[5] !=null && jsonObj.JsonResVO[5].getResMsg == "Approval"){ //전자결재 연계 파일 용
                			if(filetotal + parseInt(jsonObj.JsonResVO[3].getResMsg) > 20971520){
                        		alert('첨부파일 총 용량은 20MB를 초과할 수 없습니다.');
                        		filedelete(jsonObj.JsonResVO[4].getResMsg,false);
                        		return;
                        	}
                    
                        	filecnt++;
                        	filetotal +=  parseInt(jsonObj.JsonResVO[2].getResMsg);
                        	$("#filetotal").html(AddComma(filetotal) + " byte");
                        	downloadRow = uploadHandler.buildDownloadRow(jsonObj.JsonResVO[1].getResMsg,jsonObj.JsonResVO[2].getResMsg,jsonObj.JsonResVO[3].getResMsg);
                            if (downloadRow) {
                                downloadRow.appendTo(uploadHandler.downloadTable).fadeIn();
                            }
                		}else{
                			if(parseInt(jsonObj.JsonResVO[3].getResMsg) > 94371840){
                        		alert('첨부파일 용량이 90MB를 초과할 수 없습니다.');
                        		filedelete(jsonObj.JsonResVO[4].getResMsg,false);
                        		return;
                        	}
                    
                        	filecnt++;
                        	filetotal +=  parseInt(jsonObj.JsonResVO[2].getResMsg);
                        	$("#filetotal").html(AddComma(filetotal) + " byte");
                        	downloadRow = uploadHandler.buildDownloadRow(jsonObj.JsonResVO[1].getResMsg,jsonObj.JsonResVO[2].getResMsg,jsonObj.JsonResVO[3].getResMsg);
                            if (downloadRow) {
                                downloadRow.appendTo(uploadHandler.downloadTable).fadeIn();
                            }
                		}
                	}else{
            			if(parseInt(jsonObj.JsonResVO[2].getResMsg) > 94371840){
                    		alert('첨부파일 용량이 90MB를 초과할 수 없습니다.');
                    		filedelete(jsonObj.JsonResVO[3].getResMsg,false);
                    		return;
                    	}
                
                    	filecnt++;
                    	filetotal +=  parseInt(jsonObj.JsonResVO[2].getResMsg);
                    	$("#filetotal").html(AddComma(filetotal) + " byte");
                    	downloadRow = uploadHandler.buildDownloadRow(jsonObj.JsonResVO[1].getResMsg,jsonObj.JsonResVO[2].getResMsg,jsonObj.JsonResVO[3].getResMsg);
                        if (downloadRow) {
                            downloadRow.appendTo(uploadHandler.downloadTable).fadeIn();
                        }
                	}
                }
			} catch (e) {
				// alert(jsonObj.JsonResVO[0].getResMsg);
				alert(e);
				alert('첨부파일 용량이 90MB를 초과할 수 없습니다.');
			}
            
        };
        
        this.documentDragEnter = function (event) {
            setTimeout(function () {
                if (dragLeaveTimeout) {
                    clearTimeout(dragLeaveTimeout);
                }
            }, 50);
            if (!isDropZoneEnlarged) {
                dropZone.switchClass(
                    uploadHandler.cssClassSmall,
                    uploadHandler.cssClassLarge
                );
                isDropZoneEnlarged = true;
            }
        };
        
        this.documentDragLeave = function (event) {
            if (dragLeaveTimeout) {
                clearTimeout(dragLeaveTimeout);
            }
            dragLeaveTimeout = setTimeout(function () {
                dropZone.switchClass(
                    uploadHandler.cssClassLarge,
                    uploadHandler.cssClassSmall
                );
                isDropZoneEnlarged = false;
            }, 100);
        };
        
        this.dragEnter = this.dragLeave = function (event) {
            dropZone.toggleClass(uploadHandler.cssClassHighlight);
        };
        
        this.drop = function (event) {
            dropZone.effect(uploadHandler.dropEffect, function () {
                dropZone.removeClass(uploadHandler.cssClassHighlight);
                dropZone.switchClass(
                    uploadHandler.cssClassLarge,
                    uploadHandler.cssClassSmall
                );
            });
        };
        
        $.extend(this, options);
    },

    methods = {
        init : function (options) {
            return this.each(function () {
                $(this).fileUpload(new UploadHandler($(this), options));
            });
        },
                
        destroy : function (namespace) {
            return this.each(function () {
                $(this).fileUpload('destroy', namespace);
            });
        }
    };
    
    $.fn.fileUploadUI = function (method) {
        if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || ! method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.fileUploadUI');
        }
    };
    
}(jQuery));