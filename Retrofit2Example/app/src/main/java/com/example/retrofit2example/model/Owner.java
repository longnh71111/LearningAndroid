package com.example.retrofit2example.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Owner{
	public Owner() {
	}

	@SerializedName("gists_url")
	private String gistsUrl;

	@SerializedName("repos_url")
	private String reposUrl;

	@SerializedName("following_url")
	private String followingUrl;

	@SerializedName("starred_url")
	private String starredUrl;

	@SerializedName("login")
	private String login;

	@SerializedName("followers_url")
	private String followersUrl;

	@SerializedName("type")
	private String type;

	@SerializedName("url")
	private String url;

	@SerializedName("subscriptions_url")
	private String subscriptionsUrl;

	@SerializedName("received_events_url")
	private String receivedEventsUrl;

	@SerializedName("avatar_url")
	private String avatarUrl;

	@SerializedName("events_url")
	private String eventsUrl;

	@SerializedName("html_url")
	private String htmlUrl;

	@SerializedName("site_admin")
	private boolean siteAdmin;

	@SerializedName("id")
	private int id;

	@SerializedName("gravatar_id")
	private String gravatarId;

	@SerializedName("node_id")
	private String nodeId;

	@SerializedName("organizations_url")
	private String organizationsUrl;
}