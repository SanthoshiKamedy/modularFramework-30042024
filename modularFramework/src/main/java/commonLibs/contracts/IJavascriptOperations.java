package commonLibs.contracts;

public interface IJavascriptOperations {
	
	public void executeJavaScript(String scriptToExcute)throws Exception;
	
	public void scrollDown(int x,int y) throws Exception;
	
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception;

}
