package ozaii.Badges;

public class Badge {
    private final EnumBadgeTypes badgeType;
    private final int level;

    public Badge(EnumBadgeTypes badgeType, int level) {
        this.badgeType = badgeType;
        this.level = level;
    }

    public int getId() {
        return badgeType.getId();
    }

    public String getName() {
        return badgeType.getName();
    }

    public LocalDate getDate() {
        return badgeType.getDate();
    }

    public int getLevel() {
        return level;
    }
}
