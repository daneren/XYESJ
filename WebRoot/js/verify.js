//����Ajax�첽����
function createAJAX(){
    var ajax = null;
    try{
        //���IE5=IE12�Ļ�
        ajax = new ActiveXObject("microsoft.xmlhttp");
    }catch(e1){
        try{
            //����Ƿ�IE�Ļ�
            ajax = new XMLHttpRequest();
        }catch(e2){
            alert("���������в�֧���첽�����뻻�����");
        }
    }
    
    return ajax;       	        	
}