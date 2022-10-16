package factoryRequest;

public class CRequestFactory {

    public static IRequest make(String vStrType) {
        IRequest request;

        switch (vStrType) {
            case "post":
                request = new CRequestPost();
                break;
            case "put":
                request = new CRequestPut();
                break;
            case "delete":
                request = new CRequestDelete();
                break;
            default:
                request = new CRequestGet();
                break;
        }

        return request;
    }
}
