package com.yijava.web.vo;



public class Result<T> {
	public final static int SUCCESS_STATE = 1;
	public final static int ERROR_STATE = 0;

	private T data;
	private Integer state;
	private ErrorCode error;
	
	public Result(){
	}
	
	
	
	public Result(T data, Integer state) {
		super();
		this.data = data;
		this.state = state;
	}



	public Result(Integer status,T data,ErrorCode error){
		this.state = status;
		this.data = data;
		this.error = error;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer status) {
		this.state = status;
	}
	public ErrorCode getError() {
		return error;
	}
	public void setError(ErrorCode error) {
		this.error = error;
	}
	
	/**
	 * 通用成功结果对象
	 * @return
	 */
	public static <T> Result<T> success(T value){
		Result<T> res = new Result<T>();
		res.setData(value);
		res.setState(SUCCESS_STATE);
		return res;
	}
	
	   /**
     * 通用成功结果对象
     * @return
     */
    public static Result<Void> success(){
        Result<Void> res = new Result<Void>();
        res.setState(SUCCESS_STATE);
        return res;
    }
	
	/**
	 * 返回通用错误结果
	 * @param error
	 * @return
	 */
	public static Result<Void> error(ErrorCode error){
		Result<Void> res = new Result<Void>();
		res.setState(ERROR_STATE);
		res.setError(error);
		return res;
	}
}
