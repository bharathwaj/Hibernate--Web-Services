package com.uic.edu.restfull.implementation.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.uic.edu.restfull.implementation.messenger.model.Message;
import com.uic.edu.restfull.implementation.messenger.resources.beans.MessageFilterBean;
import com.uic.edu.restfull.implementation.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesJSON(@BeanParam MessageFilterBean filterbean) {
		if (filterbean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterbean.getYear());
		}
		if (filterbean.getStart() >= 0 && filterbean.getSizel() > 0) {
			return messageService.getAllMessagePaginated(filterbean.getStart(), filterbean.getSizel());
		}
		return messageService.getAllMessages();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getMessagesXML(@BeanParam MessageFilterBean filterbean) {
		if (filterbean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterbean.getYear());
		}
		if (filterbean.getStart() >= 0 && filterbean.getSizel() > 0) {
			return messageService.getAllMessagePaginated(filterbean.getStart(), filterbean.getSizel());
		}
		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMMessage(@PathParam("messageId") Long messageId, @Context UriInfo uriInfo) {

		Message mess = messageService.getMessage(messageId);
		mess.addLink(getUriForSelf(uriInfo, mess), "self");
		mess.addLink(getUriForProfile(uriInfo, mess), "profile");
		return mess;

	}

	private String getUriForProfile(UriInfo uriInfo, Message mess) {
		String uri = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path((mess.getAuthor())).build()
				.toString();
		return uri;
	}

	private String getUriForSelf(UriInfo uriInfo, Message mess) {
		String uri = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Long.toString(mess.getId())).build()
				.toString();
		return uri;
	}

	@POST
	public Response addMessage(Message message, @Context UriInfo uriinfo) throws URISyntaxException {
		Message mes = messageService.addMessage(message);
		String idnet = String.valueOf(mes.getId());
		URI url = uriinfo.getAbsolutePathBuilder().path(idnet).build();
		return Response.created(url)
				// .status(Status.CREATED)
				.entity(mes).build();

		// return
	}

	@PUT
	@Path("/{messageId}")

	public Message updateMessage(@PathParam("messageId") Long messageId, Message message) {
		System.out.println("Hello");
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") Long messageId) {
		messageService.removeMessage(messageId);
	}

	@Path("{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
