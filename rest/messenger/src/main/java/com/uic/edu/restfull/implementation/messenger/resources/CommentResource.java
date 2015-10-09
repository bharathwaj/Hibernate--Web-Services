package com.uic.edu.restfull.implementation.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {
	@GET
	public String test() {
		return "Sub Resource Tested";
	}

	@GET
	@Path("/{commendId}")
	public String test2(@PathParam("messageId") Long messageId, @PathParam("commendId") Long commendId) {
		return "CommentId Tested!!+messageId+";
	}
}
