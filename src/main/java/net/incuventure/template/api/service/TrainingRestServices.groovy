package net.incuventure.template.api.service

import com.google.gson.Gson
import org.springframework.stereotype.Component

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.core.UriInfo
import javax.ws.rs.core.Response

@Path("/training")
@Component
class TrainingRestServices {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/testEvent")
    public Response testEvent(@Context UriInfo allUri) {

        Gson gson = new Gson();

        String result = "";
        Map returnMap = new HashMap();
        Map jsonParams = new HashMap<String, String>();

        // get all query parameters
        MultivaluedMap<String, String> mpAllQueParams = allUri.getQueryParameters();

        for (String key : mpAllQueParams.keySet()) {
            // if there are multiple instances of the same param, we only use the first one
            jsonParams.put(key, mpAllQueParams.getFirst(key).toString());
        }

        try {

            returnMap.put("status", "ok");

        } catch (Exception e) {

            Map errorDetails = new HashMap();

            e.printStackTrace();

            errorDetails.put("code", e.getMessage());
            errorDetails.put("description", e.toString());

            returnMap.put("status", "error");
            returnMap.put("error", errorDetails);
        }

        // format return data as json
        result = gson.toJson(returnMap);

        // todo: we should probably return the appropriate HTTP error codes instead of always returning 200
        return Response.status(200).entity(result).build();
    }

}
