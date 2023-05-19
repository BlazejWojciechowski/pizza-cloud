delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;

delete from Ingredient;
insert into Ingredient (id, name, type) 
                values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type) 
                values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type) 
                values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type) 
                values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type) 
                values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type) 
                values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type) 
                values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type) 
                values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type) 
                values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type) 
                values ('SRCR', 'Sour Cream', 'SAUCE');
delete
from Pizza_Order_Pizzas;
delete
from Pizza_Ingredients;
delete
from Pizza;
delete
from Pizza_Order;
delete
from Ingredient;

insert into Ingredient (id, name, type)
values ('THIN', 'Thin Dough', 'DOUGH');
insert into Ingredient (id, name, type)
values ('FATT', 'Fat Dough', 'DOUGH');
insert into Ingredient (id, name, type)
values ('SALA', 'Salami', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('PROS', 'Prosciutto', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('TMTO', 'Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('OLIV', 'Olives', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('PICK', 'Pickles', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
values ('MOZZ', 'Mozzarella', 'CHEESE');
insert into Ingredient (id, name, type)
values ('ARUG', 'Arugula', 'SALAD');
insert into Ingredient (id, name, type)
values ('BASI', 'Basil', 'SALAD');
insert into Ingredient (id, name, type)
values ('SLSA', 'Salsa Sauce', 'SAUCE');
insert into Ingredient (id, name, type)
values ('STMT', 'Tomato Sauce', 'SAUCE');
