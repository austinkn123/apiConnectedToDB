package com.example.rest.Models;

//import org.springframework.context.annotation.Bean;


import javax.persistence.*;

@Entity
@Table(name="Recipes")
//@Bean(name=“entityManagerFactory”)
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodID;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Rating")
    private String Rating;
    @Column(name = "EaseOfPrep")
    private String EaseOfPrep;
    @Column(name = "Notes")
    private String Notes;
    @Column(name = "Type")
    private String Type;
    @Column(name = "PrepTime")
    private String PrepTime;
    @Column(name = "Ingredients")
    private String Ingredients;

    @Column(name = "Favorite")
    private Boolean Favorite;

    public Recipes() {
    }

    public Recipes(Integer foodID, String Name, String Rating, String EaseOfPrep,
                   String Notes, String Type, String PrepTime, String Ingredients, Boolean Favorite){
        this.foodID = foodID;
        this.Name = Name;
        this.Rating = Rating;
        this.EaseOfPrep = EaseOfPrep;
        this.Notes = Notes;
        this.Type = Type;
        this.PrepTime = PrepTime;
        this.Ingredients = Ingredients;
        this.Favorite = Favorite;
    }

    public void setFoodID(Integer foodID) {this.foodID = foodID;}
    public Integer getFoodID() {return foodID;}

    public void setName(String Name) {this.Name = Name;}
    public String getName() {return Name;}

    public void setRating(String Rating) {this.Rating = Rating;}
    public String getRating() {return Rating;}

    public void setEaseOfPrep(String EaseOfPrep) {this.EaseOfPrep = EaseOfPrep;}
    public String getEaseOfPrep() {return EaseOfPrep;}

    public void setNotes(String Notes) {this.Notes = Notes;}
    public String getNotes() {return Notes;}

    public void setType(String Type) {this.Type = Type;}
    public String getType() {return Type;}

    public void setPrepTime(String PrepTime) {this.PrepTime = PrepTime;}
    public String getPrepTime() {return PrepTime;}

    public void setIngredients(String Ingredients) {this.Ingredients = Ingredients;}
    public String getIngredients() {return Ingredients;}

    public void setFavorite(Boolean Favorite) {this.Favorite = Favorite;}
    public Boolean getFavorite() {return Favorite;}

}