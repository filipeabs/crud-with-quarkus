package dev.filipeabs.rest;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import dev.filipeabs.models.LogUse;
import dev.filipeabs.services.LogUseService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/logs")
@RequestScoped
public class LogUseRest {

    @Inject
    LogUseService service;

    @GET
    @Operation(summary = "Listar LOGs ", description = "Retorna uma lista de todos os Logs.")
    @APIResponse(responseCode = "200", description = "Logs", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = LogUse.class, type = SchemaType.ARRAY)) })
    public Response obter() throws Exception {
        return Response.status(Response.Status.OK).entity(service.retornarLogs()).build();
    }

    @GET
    @Path("/logMaisRecente/{nrUse}")
    @Operation(summary = "Obter um Log", description = "Retornar LOG mais recente pelo numero informado.")
    @APIResponse(responseCode = "200", description = "Log Retornado", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = LogUse.class, type = SchemaType.ARRAY)) })
    public Response obterRecente(final @PathParam("nrUse") long nrUse) throws Exception {
        return Response.status(Response.Status.OK).entity(service.retornarLogRecente(nrUse)).build();
    }

    @GET
    @Path("/{nrUse}")
    @Operation(summary = "Listar Logs de um numero informado", description = "Retorna uma lista de LOGs baseado no numero informado.")
    @APIResponse(responseCode = "200", description = "Logs", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = LogUse.class, type = SchemaType.ARRAY)) })
    public Response obter(final @PathParam("nrUse") long nrUse) throws Exception {
        return Response.status(Response.Status.OK).entity(service.retornarLogs(nrUse)).build();
    }

    @POST
    @Operation(summary = "Incluir um Log.", description = "Incluir um Log")
    @APIResponse(responseCode = "201", description = "Log", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = LogUse.class)) })
    public Response inserir(LogUse logUse) throws Exception {
        return Response.status(Response.Status.CREATED).entity(service.inserirLog(logUse)).build();
    }

    @DELETE
    @Path("/{nrUse}")
    @Operation(summary = "Remove um Log", description = "Remove um Log pelo numero informado.")
    @APIResponse(responseCode = "200", description = "Log", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = LogUse.class)) })
    public Response excluir(final @PathParam("nrUse") long nrUse) throws Exception {
        return Response.status(Response.Status.OK).entity(service.excluirLog(nrUse)).build();
    }

    @DELETE
    @Operation(summary = "Remove todos os Logs", description = "Remove todos os Logs da base.")
    @APIResponse(responseCode = "200", description = "Logs Removidos", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = LogUse.class)) })
    public Response excluir() throws Exception {
        return Response.status(Response.Status.OK).entity(service.excluirLogs()).build();
    }

    @PUT
    @Path("/{nrUse}")
    @Operation(summary = "Atualizar um Log", description = "Atualização de um Log")
    @APIResponse(responseCode = "200", description = "Log", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = LogUse.class)) })
    public Response atualizar(final @PathParam("nrUse") long nrUse, LogUse logUse) throws Exception {
        return Response.status(Response.Status.OK).entity(service.atualizarLog(nrUse, logUse)).build();
    }
}
