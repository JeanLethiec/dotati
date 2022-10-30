package com.ceihtel.dotati.opendota;

import com.ceihtel.dotati.dtos.Tournament;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import java.util.List;

@RegisterRestClient(configKey = "tournaments-api")
public interface TournamentsService {
    @GET
    Uni<List<Tournament>> list();
}
