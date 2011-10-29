/*     */ package net.gamerservices.fantasyraces;
/*     */ 
/*     */ import com.avaje.ebean.validation.Length;
/*     */ import com.avaje.ebean.validation.NotEmpty;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="fantasyraces_player")
/*     */ public class sqlPlayer
/*     */ {
/*     */ 
/*     */   @Id
/*     */   private int id;
/*     */ 
/*     */   @Length(max=16)
/*     */   @NotEmpty
/*     */   private String name;
/*     */ 
/*     */   @Length(max=32)
/*     */   @NotEmpty
/*     */   private String display;
/*     */ 
/*     */   @Length(max=32)
/*     */   private String lastname;
/*     */ 
/*     */   @Length(max=32)
/*     */   private String prefix;
/*     */ 
/*     */   @Length(max=32)
/*     */   private String title;
/*     */ 
/*     */   @Length(max=32)
/*     */   @NotEmpty
/*     */   private String race;
/*     */ 
/*     */   @Length(max=32)
/*     */   @NotEmpty
/*     */   private String language;
/*     */ 
/*     */   public void setId(int id)
/*     */   {
/*  41 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public int getId() {
/*  45 */     return this.id;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  49 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  53 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/*  57 */     if (this.title == null)
/*     */     {
/*  59 */       return "";
/*     */     }
/*  61 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/*  66 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getPrefix() {
/*  70 */     return this.prefix;
/*     */   }
/*     */ 
/*     */   public void setPrefix(String prefix) {
/*  74 */     this.prefix = prefix;
/*     */   }
/*     */ 
/*     */   public String getLastname() {
/*  78 */     return this.lastname;
/*     */   }
/*     */ 
/*     */   public void setLastname(String lastname) {
/*  82 */     this.lastname = lastname;
/*     */   }
/*     */ 
/*     */   public String getDisplay() {
/*  86 */     return this.display;
/*     */   }
/*     */ 
/*     */   public void setDisplay(String displayname) {
/*  90 */     this.display = displayname;
/*     */   }
/*     */ 
/*     */   public String getRace()
/*     */   {
/*  95 */     return this.race;
/*     */   }
/*     */ 
/*     */   public void setRace(String race) {
/*  99 */     this.race = race;
/*     */   }
/*     */ 
/*     */   public String getLanguage() {
/* 103 */     return this.language;
/*     */   }
/*     */ 
/*     */   public void setLanguage(String language) {
/* 107 */     this.language = language;
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\end\Desktop\fantasyraces.jar
 * Qualified Name:     net.gamerservices.fantasyraces.sqlPlayer
 * JD-Core Version:    0.6.0
 */