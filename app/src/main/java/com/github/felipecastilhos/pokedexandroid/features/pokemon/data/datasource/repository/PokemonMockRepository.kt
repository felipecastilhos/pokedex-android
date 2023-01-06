package com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.repository

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.github.felipecastilhos.pokedexandroid.R
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

class PokemonMockRepository {
    fun pokemonList(): List<Pokemon> =
        mutableListOf(
            Pokemon("#001", "Bulbassaur", PokemonType.GRASS, R.drawable.asset_bulbasaur),
            Pokemon("#004", "Charmander", PokemonType.FIRE, R.drawable.asset_charmander),
            Pokemon("#007", "Squirtle", PokemonType.WATER, R.drawable.asset_squirtle),
            Pokemon("#012", "Butterfree", PokemonType.BUG, R.drawable.asset_butterfree),
            Pokemon("#025", "Pikachu", PokemonType.ELETRIC, R.drawable.asset_pikachu),
            Pokemon("#092", "Gastly", PokemonType.GHOST, R.drawable.asset_gastly),
            Pokemon("#132", "Ditto", PokemonType.NORMAL, R.drawable.asset_ditto),
            Pokemon("#152", "Mew", PokemonType.PSYCHIC, R.drawable.asset_mew),
            Pokemon("#304", "Aron", PokemonType.STEEL, R.drawable.asset_aron),
        )


    fun pokemonDetail(index: Int): PokemonDetails = PokemonMock.values()[index].pokemonDetails
}


data class Pokemon(
    val pokedexId: String,
    val name: String,
    val type: PokemonType,
    @DrawableRes val pokemonAsset: Int
)

data class PokemonDetails(
    val pokedexId: String,
    val name: String,
    val types: List<PokemonType>,
    val weight: String,
    val height: String,
    val moves: List<String>,
    val aboutDescription: String,
    val baseStats: Stats,
    @DrawableRes val image: Int
)


data class Stats(
    val hp: Int,
    val atk: Int,
    val def: Int,
    val satk: Int,
    val sdef: Int,
    val spd: Int
)

enum class PokemonType {
    ROCK,
    GHOST,
    STEEL,
    WATER,
    GRASS,
    PSYCHIC,
    ICE,
    DARK,
    FAIRY,
    NORMAL,
    FIGHTING,
    FLYING,
    POISON,
    GROUND,
    BUG,
    FIRE,
    ELETRIC,
    DRAGON;

    @Composable
    fun color(): Color =
        when (this) {
            ROCK -> PokedexTheme.colors.pokemonType.rock
            GHOST -> PokedexTheme.colors.pokemonType.ghost
            STEEL -> PokedexTheme.colors.pokemonType.steel
            WATER -> PokedexTheme.colors.pokemonType.water
            GRASS -> PokedexTheme.colors.pokemonType.grass
            PSYCHIC -> PokedexTheme.colors.pokemonType.psychic
            ICE -> PokedexTheme.colors.pokemonType.ice
            DARK -> PokedexTheme.colors.pokemonType.dark
            FAIRY -> PokedexTheme.colors.pokemonType.fairy
            NORMAL -> PokedexTheme.colors.pokemonType.normal
            FIGHTING -> PokedexTheme.colors.pokemonType.fighting
            FLYING -> PokedexTheme.colors.pokemonType.flying
            POISON -> PokedexTheme.colors.pokemonType.poison
            GROUND -> PokedexTheme.colors.pokemonType.ground
            BUG -> PokedexTheme.colors.pokemonType.bug
            FIRE -> PokedexTheme.colors.pokemonType.fire
            ELETRIC -> PokedexTheme.colors.pokemonType.eletric
            DRAGON -> PokedexTheme.colors.pokemonType.dragon
        }

}


enum class PokemonMock(val pokemonDetails: PokemonDetails) {
    BULBASSAUR(
        PokemonDetails(
            pokedexId = "#001",
            name = "Bulbassaur",
            types = mutableListOf(PokemonType.GRASS, PokemonType.POISON),
            weight = "6,9 kg",
            height = "0,7 m",
            moves = mutableListOf("Chlorophyll", "Overgrow"),
            aboutDescription = "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.",
            baseStats = Stats(
                hp = 45,
                atk = 49,
                def = 49,
                satk = 65,
                sdef = 65,
                spd = 45
            ),
            image = R.drawable.asset_bulbasaur
        )
    ),
    CHARMANDER(
        PokemonDetails(
            pokedexId = "#004",
            name = "Charmander",
            types = mutableListOf(PokemonType.FIRE),
            weight = "8,5 kg",
            height = "0.6 m",
            moves = mutableListOf("Mega-Punch", "Fire-Punch"),
            aboutDescription = "It has a preference for hot things. When it rains, steam is said to spout from the tip of its tail.",
            baseStats = Stats(
                hp = 39,
                atk = 52,
                def = 43,
                satk = 60,
                sdef = 50,
                spd = 65
            ),
            image = R.drawable.asset_charmander
        )
    ),
    SQUIRTLE(
        PokemonDetails(
            pokedexId = "#007",
            name = "Squirtle",
            types = mutableListOf(PokemonType.WATER),
            weight = "9,0 kg",
            height = "0,5 m",
            moves = mutableListOf("Torrent", "Rain-Dish"),
            aboutDescription = "When it retracts its long neck into its shell, it squirts out water with vigorous force.",
            baseStats = Stats(
                hp = 44,
                atk = 48,
                def = 65,
                satk = 50,
                sdef = 64,
                spd = 43
            ),
            image = R.drawable.asset_squirtle
        )
    ),
    BUTTERFREE(
        PokemonDetails(
            pokedexId = "#012",
            name = "Butterfree",
            types = mutableListOf(PokemonType.BUG, PokemonType.FLYING),
            weight = "32,0 kg",
            height = "1,1 m",
            moves = mutableListOf("Compound-Eyes", "Tinted-Lens"),
            aboutDescription = "In battle, it flaps its wings at great speed to release highly toxic dust into the air.",
            baseStats = Stats(
                hp = 60,
                atk = 45,
                def = 50,
                satk = 90,
                sdef = 80,
                spd = 70
            ),
            image = R.drawable.asset_butterfree
        )
    ),
    PIKACHU(
        PokemonDetails(
            pokedexId = "#025",
            name = "Pikachu",
            types = mutableListOf(PokemonType.ELETRIC),
            weight = "6,0 kg",
            height = "0,4 m",
            moves = mutableListOf("Mega-Punch", "Pay-Day"),
            aboutDescription = "Pikachu that can generate powerful electricity have cheek sacs that are extra soft and super stretchy.",
            baseStats = Stats(
                hp = 35,
                atk = 55,
                def = 40,
                satk = 50,
                sdef = 50,
                spd = 90
            ),
            image = R.drawable.asset_pikachu
        )
    ),
    GASTLY(
        PokemonDetails(
            pokedexId = "#092",
            name = "Gasly",
            types = mutableListOf(PokemonType.GHOST, PokemonType.POISON),
            weight = "0,1 kg",
            height = "1,3 m",
            moves = mutableListOf("Levitate"),
            aboutDescription = "Born from gases, anyone would faint if engulfed by its gaseous body, which contains poison.",
            baseStats = Stats(
                hp = 30,
                atk = 35,
                def = 30,
                satk = 100,
                sdef = 35,
                spd = 80
            ),
            image = R.drawable.asset_gastly
        )
    ),
    DITTO(
        PokemonDetails(
            pokedexId = "#0132",
            name = "Ditto",
            types = mutableListOf(PokemonType.NORMAL),
            weight = "4,0 kg",
            height = "0,3 m",
            moves = mutableListOf("Limber", "Impostor"),
            aboutDescription = "BIt can reconstitute its entire cellular structure to change into what it sees, but it returns to normal when it relaxes.",
            baseStats = Stats(
                hp = 48,
                atk = 48,
                def = 48,
                satk = 48,
                sdef = 48,
                spd = 48
            ),
            image = R.drawable.asset_ditto
        )
    ),
    MEW(
        PokemonDetails(
            pokedexId = "#0152",
            name = "Mew",
            types = mutableListOf(PokemonType.PSYCHIC),
            weight = "4,0 kg",
            height = "0,4 m",
            moves = mutableListOf("Synchronize"),
            aboutDescription = "When viewed through a microscope, this Pokémon’s short, fine, delicate hair can be seen.",
            baseStats = Stats(
                hp = 100,
                atk = 100,
                def = 100,
                satk = 100,
                sdef = 100,
                spd = 100
            ),
            image = R.drawable.asset_mew
        )
    ),
    ARON(
        PokemonDetails(
            pokedexId = "#0304",
            name = "Aron",
            types = mutableListOf(PokemonType.STEEL),
            weight = "60,0 kg",
            height = "0,4 m",
            moves = mutableListOf("Sturdy", "Rock-Head"),
            aboutDescription = "It eats iron ore - and sometimes railroad tracks - to build up the steel armor that protects its body.",
            baseStats = Stats(
                hp = 50,
                atk = 70,
                def = 100,
                satk = 40,
                sdef = 40,
                spd = 30
            ),
            image = R.drawable.asset_aron
        )
    ),
}