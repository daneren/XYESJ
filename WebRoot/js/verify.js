//创建Ajax异步对象
function createAJAX(){
    var ajax = null;
    try{
        //如果IE5=IE12的话
        ajax = new ActiveXObject("microsoft.xmlhttp");
    }catch(e1){
        try{
            //如果是非IE的话
            ajax = new XMLHttpRequest();
        }catch(e2){
            alert("你的浏览器中不支持异步对象，请换浏览器");
        }
    }
    
    return ajax;       	        	
}