package ozaii.Badges;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public enum EnumBadgeTypes {
    BADGE1(1, "Rozet 1", LocalDate.of(2023, 8, 1)),
    BADGE2(2, "Rozet 2", LocalDate.of(2023, 8, 10)),
    BADGE3(3, "Rozet 3", LocalDate.of(2023, 8, 15));

    private final int id;
    private final String name;
    private final LocalDate date;

    private static final Map<Integer, EnumBadgeTypes> idMap = new HashMap<>();

    static {
        for (EnumBadgeTypes badge : EnumBadgeTypes.values()) {
            idMap.put(badge.id, badge);
        }
    }

    EnumBadgeTypes(int id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public static EnumBadgeTypes getById(int id) {
        return idMap.get(id);
    }
}
