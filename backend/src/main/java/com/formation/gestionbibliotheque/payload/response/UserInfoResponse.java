package com.formation.gestionbibliotheque.payload.response;

import java.util.List;

public class UserInfoResponse {
    private String message;

	public void MessageResponse(String message) {
	    this.message = message;
	  }

	public UserInfoResponse(Long id, String message, String string, List<String> roles) {
        this.message = message;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
