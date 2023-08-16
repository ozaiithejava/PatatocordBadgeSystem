package ozii.Badges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadgeManager {
    private List<Badge> badges;
    private Map<String, List<Badge>> playerBadgesMap;

    public BadgeManager() {
        this.badges = new ArrayList<>();
        this.playerBadgesMap = new HashMap<>();
    }

    public void addBadge(String playerName, int level, EnumBadgeTypes type) {
        Badge badge = new Badge(type, level);
        badge.setPlayerName(playerName);
        badges.add(badge);

        playerBadgesMap.computeIfAbsent(playerName, k -> new ArrayList<>()).add(badge);
        System.out.println("Badge added to " + playerName);
    }

    public void removeBadge(String playerName) {
        List<Badge> removedBadges = playerBadgesMap.remove(playerName);
        if (removedBadges != null) {
            badges.removeAll(removedBadges);
            System.out.println("Badges removed from " + playerName);
        } else {
            System.out.println("No badges found for " + playerName);
        }
    }

    public void setBadgeLevel(EnumBadgeTypes type, String playerName, int level) {
        List<Badge> playerBadges = playerBadgesMap.get(playerName);
        if (playerBadges != null) {
            for (Badge badge : playerBadges) {
                if (badge.getBadgeType() == type) {
                    badge.setLevel(level);
                    System.out.println("Badge level updated for " + playerName);
                    return;
                }
            }
            System.out.println("No badge found with type " + type + " for " + playerName);
        } else {
            System.out.println("No badges found for " + playerName);
        }
    }

    public void removeAllBadges(String playerName) {
        List<Badge> removedBadges = playerBadgesMap.remove(playerName);
        if (removedBadges != null) {
            badges.removeAll(removedBadges);
            System.out.println("All badges removed from " + playerName);
        } else {
            System.out.println("No badges found for " + playerName);
        }
    }

    public List<Badge> getAllBadgeTypes() {
        List<Badge> allBadgeTypes = new ArrayList<>();
        for (EnumBadgeTypes type : EnumBadgeTypes.values()) {
            allBadgeTypes.add(new Badge(type, 1));
        }
        return allBadgeTypes;
    }

    public List<Badge> getAllBadges() {
        return new ArrayList<>(badges);
    }

    public List<Badge> getAllBadgesWithTypes(EnumBadgeTypes type) {
        List<Badge> badgesWithType = new ArrayList<>();
        for (Badge badge : badges) {
            if (badge.getBadgeType() == type) {
                badgesWithType.add(badge);
            }
        }
        return badgesWithType;
    }

    public List<Badge> getAllBadgesWithLevel(int level) {
        List<Badge> badgesWithLevel = new ArrayList<>();
        for (Badge badge : badges) {
            if (badge.getLevel() == level) {
                badgesWithLevel.add(badge);
            }
        }
        return badgesWithLevel;
    }

    public List<Badge> getAllBadgesFromPlayer(String playerName) {
        List<Badge> playerBadges = playerBadgesMap.get(playerName);
        if (playerBadges != null) {
            return new ArrayList<>(playerBadges);
        }
        return new ArrayList<>();
    }

    public void resetPlayerBadges(String playerName) {
        playerBadgesMap.remove(playerName);
        System.out.println("All badges removed from " + playerName);
    }
}
