package com.ceihtel.dotati;

import com.ceihtel.dotati.dtos.Match;
import com.ceihtel.dotati.dtos.Tournament;
import com.ceihtel.dotati.opendota.TournamentsService;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/ti")
@Slf4j
@ApplicationScoped
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class DotaTiController {
    @RestClient
    TournamentsService tournamentsService;

    @GET
    public Uni<List<Tournament>> listOccurrences() {
        return tournamentsService.list()
                .map(x -> x.stream()
                        .filter(Tournament::isTheInternational)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList()));
    }

    @GET
    @Path("/{tournamentId}")
    public Uni<List<Match>> getDetails(@PathParam("tournamentId") Long tournamentId) {
        return tournamentsService.listMatches(tournamentId);
    }
}
