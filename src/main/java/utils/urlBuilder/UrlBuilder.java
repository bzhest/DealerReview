package utils.urlBuilder;

/**
 * Created by SYSTEM on 26.04.2017.
 */
public class UrlBuilder {
    private String protocol = "http";
    private String domain = "";
    private String port = "";
    private String pass = "";
    private String fileName = "";
    private String params = "";
    private String anchor = "#";

    public UrlBuilder withProtocol(Boolean isSecure) {
        if (isSecure)
            protocol += "s";
        return this;
    }

    public UrlBuilder withDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public UrlBuilder withPort(String port) {
        if (!port.equals("80") || !port.equals("443"))
            this.port = ":" + port;
        return this;
    }

    public UrlBuilder withPass(String pass) {
        if (pass.startsWith("/")) {
            this.pass = pass;
        } else {
            this.pass = "/" + pass;
        }
        return this;
    }

    public UrlBuilder withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public UrlBuilder withParams(String key, String value) {
        if (!this.params.startsWith("?")) {
            this.params += "?";
            this.params += key + "=" + value + "&";
        }
        return this;
    }

    public UrlBuilder withAnchor(String anchor) {
        if(anchor.startsWith("#")){
            this.anchor = anchor;
        }else{
            this.anchor = "#" + anchor;
        }
        return this;
    }

    public String builder(){
        return protocol + "://" + domain + port + pass + fileName + params + anchor;
    }
}
