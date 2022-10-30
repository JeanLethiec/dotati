package com.ceihtel.dotati;

import com.ceihtel.dotati.dtos.Tournament;
import com.ceihtel.dotati.opendota.TournamentsService;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/ti")
@ApplicationScoped
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class DotaTiController {
    @RestClient
    TournamentsService tournamentsService;

    @GET
    @Path("/health")
    public Uni<String> health() {
        return Uni.createFrom().item("Service UP !");
    }

    @GET
    public Uni<List<Tournament>> listTiOccurencees() {
        return tournamentsService.list()
                .map(x -> x.stream()
                        .filter(Tournament::isTheInternational)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList()));
    }
}
