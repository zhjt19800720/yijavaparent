package com.yijava.web.vo;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.google.common.collect.Maps;

public class ErrorCode {

	private Integer code;

	private String msg;

	//private boolean show;

	public static final ErrorCode SUCCESS_CODE = new ErrorCode(null, "success");

	public ErrorCode() {
	}

	public ErrorCode(String msg) {
		this.msg = msg;
	}
	public ErrorCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer errorCode) {
		this.code = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	

	/**
	 * 当前请求是否失败, 或者 不是成功的一次请求
	 * 
	 * @return 当没有errorCode 没有值的时候
	 */
	@JsonIgnore
	public boolean isFailed() {
		return this.code != null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		ErrorCode code = (ErrorCode) obj;

		// 如果两个Code对象 的Code都为空，则表示都是一个
		if (code.getCode() == null && getCode() == null) {
			return true;
		}

		if (code.getCode() == null && getCode() != null) {
			return false;
		}

		if (code.getCode() != null && getCode() == null) {
			return false;
		}
		return getCode().equals(code.getCode());
	}

	@Override
	public int hashCode() {
		Integer code = getCode();
		if (code == null) {
			return 0;
		}
		return code.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder(50);
		buf.append("[ErrorCode] - code:").append(this.getCode())
				.append(", msg:").append(this.getMsg());
		return buf.toString();
	}

	public Map<String, Object> asMap() {
		Map<String, Object> map = Maps.newHashMap();
		if (getCode() != null) {
			map.put("code", getCode());
		}
		if (getMsg() != null) {
			map.put("msg", getMsg());
		}
		return map;
	}

	/**
	 * 判断某个ErrorCode是否为成功的Code
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isSuccessCode(ErrorCode code) {
		return code == null || ErrorCode.SUCCESS_CODE.equals(code);
	}

	/**
	 * 创建一个成功标记的 Code，附带提示信息
	 * 
	 * @param message
	 * @return
	 */
	public static ErrorCode createSuccessCode(String message) {
		return new ErrorCode(null, message);
	}
}
