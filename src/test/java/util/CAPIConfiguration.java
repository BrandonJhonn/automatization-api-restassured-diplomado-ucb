package util;

public class CAPIConfiguration {

    /// CRUD PROJECT
    public static final String CREATE_PROJECT = CGetProperties.getInstance().getpStrHost() + "/api/projects.json";
    public static final String READ_PROJECT = CGetProperties.getInstance().getpStrHost() + "/api/projects/%s.json";
    public static final String UPDATE_PROJECT = CGetProperties.getInstance().getpStrHost() + "/api/projects/%s.json";
    public static final String DELETE_PROJECT = CGetProperties.getInstance().getpStrHost() + "/api/projects/%s.json";

    /// CRUD ITEMS
    public static final String CREATE_ITEM = CGetProperties.getInstance().getpStrHost() + "/api/items.json";
    public static final String READ_ITEM = CGetProperties.getInstance().getpStrHost() + "/api/items/%s.json";
    public static final String UPDATE_ITEM = CGetProperties.getInstance().getpStrHost() + "/api/items/%s.json";
    public static final String DELETE_ITEM = CGetProperties.getInstance().getpStrHost() + "/api/items/%s.json";
}