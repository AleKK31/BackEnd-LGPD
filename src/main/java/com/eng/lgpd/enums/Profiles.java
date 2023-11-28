package com.eng.lgpd.enums;

public enum Profiles {
	CLIENT(1, "ROLE_CLIENT"), ADMIN(2, "ROLE_ADMIN");

	private Integer code;
	private String desc;

	private Profiles() {

	}

	private Profiles(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static Profiles valueOf(int codigo) {
		for (Profiles value : Profiles.values()) {
			if (value.getCode() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid perfil code");
	}

}