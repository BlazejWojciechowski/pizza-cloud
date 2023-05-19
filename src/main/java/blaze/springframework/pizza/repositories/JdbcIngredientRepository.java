package blaze.springframework.pizza.repositories;

import blaze.springframework.pizza.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
<<<<<<< HEAD
=======

>>>>>>> origin/jdbc
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
<<<<<<< HEAD

=======
>>>>>>> origin/jdbc
    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Ingredient findById(String id) {
<<<<<<< HEAD
        return jdbc.queryForObject(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient, id);
=======
        return jdbc.queryForObject("select id, name, type from Ingredient where id=?",
        this::mapRowToIngredient, id);
>>>>>>> origin/jdbc
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
<<<<<<< HEAD
        jdbc.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
=======
            jdbc.update("insert into Ingredient (id, name, type) values (?, ?, ?)",
>>>>>>> origin/jdbc
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

<<<<<<< HEAD
    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum)
            throws SQLException {
=======
    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
>>>>>>> origin/jdbc
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/jdbc
