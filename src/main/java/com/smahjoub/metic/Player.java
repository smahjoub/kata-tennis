package com.smahjoub.metic;

/**
 * The player class with custom equals method
 * @author smahjoub
 */
public class Player {
    private final Integer id;
    private final String name;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        //Check for null and compare run-time types.
        if (obj == null || !(obj instanceof Player))
        {
            return false;
        } else {
            Player player = (Player)obj;
            return player.getName().equals(this.getName()) &&
                    player.getId().equals(this.getId());
        }
    }
}
