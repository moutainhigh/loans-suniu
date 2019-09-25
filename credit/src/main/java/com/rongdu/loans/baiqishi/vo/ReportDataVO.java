package com.rongdu.loans.baiqishi.vo;

import com.rongdu.loans.credit.common.CreditApiVo;


/**
 * 白骑士-资信云报告数据-应答报文
 * @author sunda
 * @version 2017-07-10
 */
public class ReportDataVO extends CreditApiVo{

	private static final long serialVersionUID = 2810707655568681111L;
	/**
	 * 调用结果码
	 */
	private String resultCode;
	/**
	 * 应答消息
	 */
	private String resultDesc;
	/**
	 * 资信云报告数据
	 */
	private ReportDataDetail data;

	public ReportDataVO(){
	}
	
	@Override
	public boolean isSuccess() {
		if ("CCOM1000".equals(getResultCode())) {
			return true;
		}
		return false;
	}

	@Override
	public void setSuccess(boolean success) {
		this.success = success;	
	}

	@Override
	public String getCode() {
		return getResultCode();
	}

	@Override
	public void setCode(String code) {
		
	}

	@Override
	public String getMsg() {
		return getResultDesc();
	}

	@Override
	public void setMsg(String msg) {
		
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public ReportDataDetail getData() {
		return data;
	}

	public void setData(ReportDataDetail data) {
		this.data = data;
	}
}
