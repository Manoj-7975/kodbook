package com.kodbook.entities;

import java.util.Arrays;
import java.util.Base64;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Post {
@Id
	Long id;
	String caption;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(columnDefinition = "LONGBLOB")
	byte[]photo;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Long id, String caption, byte[] photo) {
		super();
		this.id = id;
		this.caption = caption;
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getPhotoBase64() {
		if(photo==null) {
			return null;
		}
		return Base64.getEncoder().encodeToString(photo);
			}
	@Override
	public String toString() {
		return "Post [id=" + id + ", caption=" + caption + ", photo=" + Arrays.toString(photo) + "]";
	}

}
