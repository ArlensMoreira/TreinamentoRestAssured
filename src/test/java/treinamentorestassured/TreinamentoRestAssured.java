package treinamentorestassured;

import jsonobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static jsonobjects.PetInexistente.*;
import static org.hamcrest.Matchers.*;

public class TreinamentoRestAssured {

    @Test
    public void adicionarNovoPetALojaComSucesso() {
        int id = 482301;
        int categoryId = 345678;
        String CategoryName = "dog";
        String name = "dogewhere";
        String[] photourl = new String[]{"http://fotododog.com/foto1.jpeg", "http://fotododog.com/foto1.jpeg2"};
        int idTag1 = 562314;
        String nameTag1 = "macho";
        int idTag2 = 4567;
        String nameTag2 = "amarelo";
        String status = "available";


        PetObject petObject = new PetObject();
        petObject.setId(id);

        CategoryObject categoryObject = new CategoryObject();
        categoryObject.setId(categoryId);
        categoryObject.setName(CategoryName);
        petObject.setCategory(categoryObject);

        petObject.setName(name);
        petObject.setPhotoUrls(photourl);

        TagObject tag1 = new TagObject();
        TagObject tag2 = new TagObject();
        tag1.setId(idTag1);
        tag1.setName(nameTag1);

        tag2.setId(idTag2);
        tag2.setName(nameTag2);
        petObject.setTags(new TagObject[]{tag1, tag2});

        petObject.setStatus(status);


        given().
                baseUri("https://petstore.swagger.io/v2").
                basePath("pet").
                header("content-type", "Application/Json").
                body(petObject).
                when().post().
                then().statusCode(200)
                .body("id", equalTo(id),
                        " category.id", equalTo(categoryId),
                        "photoUrls [0]", equalTo("http://fotododog.com/foto1.jpeg"),
                        "photoUrls [1]", equalTo("http://fotododog.com/foto1.jpeg2"),
                        "photoUrls", hasSize(2),
                        "tags[1].name", equalTo(nameTag2),
                        "tags", hasSize(2));
    }

        // Cadastrar novo pedido de pet com sucesso (POST /store/order)
        @Test
        public void cadastrarNovoPedidoDePet(){
            int id = 482301;
            int petId = 345678;
            int quantity = 1;
            String shipDate = "2024-05-25T18:53:32.594Z";
            String status = "placed";
            String complete = "true";

            StoryOrder storyOrder = new StoryOrder();
            storyOrder.setId(id);
            storyOrder.setPetId(petId);
            storyOrder.setQuantity(quantity);
            storyOrder.setShipDate(shipDate);
            storyOrder.setStatus(status);
            storyOrder.setComplete(complete);


            given().
                    baseUri("https://petstore.swagger.io/v2").
                    basePath("store/order").
                    header("content-type", "Application/Json").
                    body(storyOrder).
                    when().post().
                    then().statusCode(200)
                    .body("id", equalTo(id),
                            "petId", equalTo(petId),
                            "quantity", equalTo(quantity),
                            "shipDate", containsString ("2024-05-25"),
                            "status", equalTo("placed"),
                            "complete", equalTo(true));



            }

    // Pesquisar por um pet inexistente (GET /pet/{petId})

    @Test
    public void pesquisarPorUmPetInexistente(){

        int id = 482201;
        int category = 242456;
        String name = "rufus";
        String[] photoUrls = new String[] {"http://wwww.fotodopet.com/rufus01", "http://wwww.fotodopet.com/rufus02" };
        int idTag1 = 424241;
        String nameTag1 = "pincher";
        int idTag2 = 5678;
        String nameTag2 = "preto";
        String status = "noexistent";


        PetInexistente petInexistente = new PetInexistente();
        petInexistente.setId(id);

        CategoryObject categoryObject = new CategoryObject();
        categoryObject.setId(id);
        categoryObject.setName(name);
        petInexistente.setPhotoUrls(photoUrls);

        TagObject tag1 = new TagObject();
        TagObject tag2 = new TagObject();
        tag1.setId(idTag1);
        tag1.setName(nameTag1);

        tag2.setId(idTag2);
        tag2.setName(nameTag2);
        petInexistente.setTags(new TagObject[]{tag1, tag2});

        petInexistente.setStatus(status);

        given().
                baseUri("https://petstore.swagger.io/v2").
                basePath("pet/{petId}").
                header("content-type", "Application/Json").
                body(petInexistente).
                when().post().
                then().statusCode(200)
                .body("id", equalTo(id),
                        "category", category(category),
                        "name", equalTo(name),
                        "photoUrls [0]", equalTo("http://wwww.fotodopet.com/rufus01"),
                        "photoUrls [1]", equalTo("http://wwww.fotodopet.com/rufus02"),
                        "status", equalTo("placed"),
                        "complete", equalTo(true));

    }

    private Object category(int category) {


        return null;
    }

//Atualizar dados de um pet existente

    @Test
    public void atualizarDadosDeUmPetExistente(){

        int id = 350428;
        int categoryId = 352015;
        String categoryName = "Ringo";
        String [] photoUrls = new String []{"http://www.petstore.com/ringo01", "http://www.petstore.com/ringo02"};
        int idTag1 = 256584;
        int idTag2 = 562475;
        String nameTag1 = "Caramelo";
        String nameTag2 = "Preto";
        String status = "available";

        TagObject [] tags = new TagObject[]{};

        TagObject.setId(id);





    }



}

