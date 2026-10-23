import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.OAuthConstants;
import org.scribe.oauth.OAuthService;




public class EtsyAPI extends DefaultApi10a{

        @Override
        public String getAccessTokenEndpoint(){

        return "https://openapi.etsy.com/v2/oauth/access_token";

        }//************************************

        @Override
        public String getRequestTokenEndpoint(){

            return "https://openapi.etsy.com/v2/oauth/request_token";

        }//*************************************

        @Override
        public String getAuthorizationUrl(Token requestToken){

        	return "https://www.etsy.com/oauth/signin?oauth_token=" + requestToken.getToken();

        }//***************************************************

}//last***********************************