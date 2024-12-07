package pairmatching.dto;

public class MenuRequest {
    private final String menu;

    public MenuRequest(String menu) {
        this.menu = menu;
    }

    public static MenuRequest from(String input) {
        return new MenuRequest(input);
    }

    public String getMenu() {
        return menu;
    }
}
