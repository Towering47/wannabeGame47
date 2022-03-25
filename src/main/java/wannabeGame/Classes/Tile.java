package wannabeGame.Classes;

public class Tile {

    private TileInteraction interaction = null;

    private boolean solid;
    public Tile (TileInteraction special, boolean block) {

        if (special != null)
            interaction = special;
        solid = block;
    }

    public TileInteraction getTileInteraction() { return interaction;}

    public void setTileInteraction(TileInteraction new_interacton) { interaction = new_interacton;}

    public boolean isSolid() { return solid;}

    public String toString() {
        if (solid) {
            return "\u001B[32m"+"▒"+"\u001B[0m";
        }
        else if(interaction != null) {
            return interaction.tileIcon();
        }
        else {
            return " ";
        }
    }
}
