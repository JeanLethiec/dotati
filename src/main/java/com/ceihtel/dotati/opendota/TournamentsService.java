package com.ceihtel.dotati.opendota;

import com.ceihtel.dotati.dtos.Match;
import com.ceihtel.dotati.dtos.Tournament;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@RegisterRestClient(configKey = "tournaments-api")
public interface TournamentsService {
    @GET
    Uni<List<Tournament>> list();

    @GET
    @Path("/{leagueid}/matches")
    Uni<List<Match>> listMatches(@PathParam("leagueid") Long leagueid);
}
