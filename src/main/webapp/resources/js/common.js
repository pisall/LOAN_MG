/**
 * 
 */
/*
 * this function splite string data which is format (yyyymmdd or yyyymmddhhssmn) into
 * plain text which is format {YEAR:"yyyy",MONTH:"mm",DAY:"dd",HH:"hh",SS:"",MN:"",ERROR:false}
 * if wrong format return 
 */
function spliteDate(strDate){
	var result={YEAR:null,MONTH:null,DAY:null,HH:null,SS:null,MN:null,ERROR:false,NO_TIME:true};
	if(strDate){
		if(strDate.length==8 || strDate.length==14){
			result.YEAR=strDate.substring(0,4);
			result.MONTH=strDate.substring(4,6);
			result.DAY=strDate.substring(6,8);
			if(strDate.length==14){
				result.NO_TIME=false;
				result.HH=strDate.substring(8,10);
				result.MN=strDate.substring(10,12);
				result.SS=strDate.substring(12,14);
			}
			return result;
		}else{
			result.ERROR=true;
			return result;
		}
	}else{
		result.ERROR=true;
		return result;
	}
	
}
function convertToStandardDateString(strDate){
	var jsonStrDate=spliteDate(strDate);
	var strResult="";
	if(!jsonStrDate.ERROR){
		strResult+=jsonStrDate.YEAR+'-'+jsonStrDate.MONTH+'-'+jsonStrDate.DAY;
		
		if(!jsonStrDate.NO_TIME){
			strResult+=" "+ jsonStrDate.HH+":"+jsonStrDate.MN+":"+jsonStrDate.SS;
		}
	}
	return strResult;
	
}
function getFormattedDate(date) {
	  var year = date.getFullYear();
	  var month = (1 + date.getMonth()).toString();
	  month = month.length > 1 ? month : '0' + month;
	  var day = date.getDate().toString();
	  day = day.length > 1 ? day : '0' + day;
	  return year + '/' + month + '/' + day;
	}