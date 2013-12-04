package controllers;

import services.APIServiceV1;
import services.APIServiceV2;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result byVersion(Long version) {
    	if(version == 1){
    		return ok(APIServiceV1.getResponse());
    	} else if (version == 2){
    		return ok(APIServiceV2.getResponse());
    	}
        return ok("Version sent = " + version);
    }
    
    public static Result unique(Long version){
    	if(version == 1){
    		return ok(APIServiceV1.getResponseUniqueV1());
    	} else if (version == 2){
    		return ok(APIServiceV2.getResponseUniqueV2());
    	}
    	return internalServerError("version not supported");
    }
    
    public static Result common(Long version){
    	if(version == 1){
    		return ok(APIServiceV1.common());
    	} else if (version == 2){
    		return ok(APIServiceV2.common());
    	}
    	return internalServerError("version not supported");
    }
    
    public static Result byHeader() {
    	System.out.println(request());
        return ok("Version sent = header " + request().getHeader("Accept"));
    }
}
