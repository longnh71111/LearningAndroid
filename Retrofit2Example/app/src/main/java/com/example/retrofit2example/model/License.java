package com.example.retrofit2example.model;

import com.google.gson.annotations.SerializedName;

public class License{

	@SerializedName("name")
	private String name;

	@SerializedName("spdx_id")
	private String spdxId;

	@SerializedName("key")
	private String key;

	@SerializedName("url")
	private String url;

	@SerializedName("node_id")
	private String nodeId;

	public License() {
	}
}