package com.learning.passGenerator.form;

public class PassConfiguration {
	
	private Integer length;
	private boolean useUpper;
	private boolean useLower;
	private boolean useNums;
	private boolean useSymbols;
	
	public PassConfiguration() {
		
	}
	public PassConfiguration(Integer length, boolean useUpper, boolean useLower, boolean useNums, boolean useSymbols) {
		this.length = length;
		this.useUpper = useUpper;
		this.useLower = useLower;
		this.useNums = useNums;
		this.useSymbols = useSymbols;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public boolean isUseUpper() {
		return useUpper;
	}

	public void setUseUpper(boolean useUpper) {
		this.useUpper = useUpper;
	}

	public boolean isUseLower() {
		return useLower;
	}

	public void setUseLower(boolean useLower) {
		this.useLower = useLower;
	}

	public boolean isUseNums() {
		return useNums;
	}

	public void setUseNums(boolean useNums) {
		this.useNums = useNums;
	}

	public boolean isUseSymbols() {
		return useSymbols;
	}

	public void setUseSymbols(boolean useSymbols) {
		this.useSymbols = useSymbols;
	}
}
