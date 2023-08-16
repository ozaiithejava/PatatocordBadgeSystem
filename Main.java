package ozaii.Badges;
public class Main {
    public static void main(String[] args) {
        BadgeManager badgeManager = new BadgeManager();

        badgeManager.addBadge("Player1", 2, EnumBadgeTypes.BADGE1);
        badgeManager.addBadge("Player2", 1, EnumBadgeTypes.BADGE2);
        badgeManager.addBadge("Player1", 3, EnumBadgeTypes.BADGE3);

        System.out.println("All Badge Types:");
        List<Badge> allBadgeTypes = badgeManager.getAllBadgeTypes();
        for (Badge badge : allBadgeTypes) {
            System.out.println("Type: " + badge.getBadgeType() + ", Level: " + badge.getLevel());
        }

        System.out.println("All Badges:");
        List<Badge> allBadges = badgeManager.getAllBadges();
        for (Badge badge : allBadges) {
            System.out.println("Player: " + badge.getPlayerName() + ", Type: " + badge.getBadgeType() + ", Level: " + badge.getLevel());
        }

        System.out.println("All Badges with Type BADGE1:");
        List<Badge> badgesWithType = badgeManager.getAllBadgesWithTypes(EnumBadgeTypes.BADGE1);
        for (Badge badge : badgesWithType) {
            System.out.println("Player: " + badge.getPlayerName() + ", Level: " + badge.getLevel());
        }

        System.out.println("All Badges with Level 2:");
        List<Badge> badgesWithLevel = badgeManager.getAllBadgesWithLevel(2);
        for (Badge badge : badgesWithLevel) {
            System.out.println("Player: " + badge.getPlayerName() + ", Type: " + badge.getBadgeType());
        }

        System.out.println("All Badges from Player1:");
        List<Badge> playerBadges = badgeManager.getAllBadgesFromPlayer("Player1");
        for (Badge badge : playerBadges) {
            System.out.println("Type: " + badge.getBadgeType() + ", Level: " + badge.getLevel());
        }

        badgeManager.setBadgeLevel(EnumBadgeTypes.BADGE1, "Player1", 4);
        badgeManager.removeBadge("Player2");
        badgeManager.removeAllBadges("Player1");

        System.out.println("After Updates and Removals:");
        List<Badge> updatedBadges = badgeManager.getAllBadges();
        for (Badge badge : updatedBadges) {
            System.out.println("Player: " + badge.getPlayerName() + ", Type: " + badge.getBadgeType() + ", Level: " + badge.getLevel());
        }

        badgeManager.resetPlayerBadges("Player1");
        System.out.println("After Reset:");
        updatedBadges = badgeManager.getAllBadges();
        for (Badge badge : updatedBadges) {
            System.out.println("Player: " + badge.getPlayerName() + ", Type: " + badge.getBadgeType() + ", Level: " + badge.getLevel());
        }
    }
}
