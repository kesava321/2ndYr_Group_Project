<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.ButtonBar?>
<?import javafx.scene.control.TitledPane?>
<?import javafx.scene.effect.Glow?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.layout.BorderPane?>
<?import javafx.scene.text.Font?>

<BorderPane stylesheets="MainMenu.css" styleClass="menu__bgr" maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/8.0.60" xmlns:fx="http://javafx.com/fxml/1">
<left>
<ButtonBar prefHeight="40.0" prefWidth="200.0" BorderPane.alignment="CENTER">
<buttons>
<AnchorPane prefHeight="200.0" prefWidth="200.0">
<children>
<Button styleClass="menu_button" layoutX="138.0" layoutY="62.0" mnemonicParsing="false" prefHeight="109.0" prefWidth="112.0" style="-fx-background-color: #b22222;" text="Electricity" textFill="WHITE">>
<effect>
<Glow />
</effect>
<font>
<Font name="System Bold Italic" size="18.0" />
</font></Button>
<Button layoutX="140.0" layoutY="197.0" mnemonicParsing="false" prefHeight="103.0" prefWidth="110.0" style="-fx-background-color: #b22222;" text="Heating" textFill="WHITE">
<effect>
<Glow />
</effect>
<font>
<Font name="System Bold Italic" size="18.0" />
</font></Button>


<!--<Button styleClass="menu__button" layoutX="138.0" layoutY="62.0" mnemonicParsing="false" prefHeight="109.0" prefWidth="112.0" text="Electricity" />-->
<!--<Button layoutX="143.0" layoutY="197.0" mnemonicParsing="false" prefHeight="103.0" prefWidth="109.0" text="Heating" />-->

<!--<Button styleClass="menu__button" layoutX="138.0" layoutY="62.0" mnemonicParsing="false" prefHeight="109.0" prefWidth="112.0" text="Electricity" />-->
<!--<Button layoutX="143.0" layoutY="197.0" mnemonicParsing="false" prefHeight="103.0" prefWidth="109.0" text="Heating" />-->

</children>
</AnchorPane>
</buttons>
</ButtonBar>
</left>
<right>
<ButtonBar prefHeight="40.0" prefWidth="200.0" BorderPane.alignment="CENTER">
<buttons>
<AnchorPane prefHeight="200.0" prefWidth="200.0">
<children>
<BorderPane layoutX="-100.0" layoutY="14.0" prefHeight="200.0" prefWidth="200.0">
<left>
<Button mnemonicParsing="false" prefHeight="107.0" prefWidth="113.0" style="-fx-background-color: #b22222;" text="Water" textFill="WHITE" BorderPane.alignment="CENTER">
<effect>
<Glow />
</effect>
<font>
<Font name="System Bold Italic" size="18.0" />
</font></Button>
</left>
</BorderPane>
<Button layoutX="-100.0" layoutY="196.0" mnemonicParsing="false" prefHeight="102.0" prefWidth="113.0" style="-fx-background-color: #b22222;" text="Gas" textFill="WHITE">
<effect>
<Glow />
</effect>
<font>
<Font name="System Bold Italic" size="18.0" />
</font></Button>
</children>
</AnchorPane>
</buttons>
</ButtonBar>
</right>
<bottom>
<ButtonBar prefHeight="3.0" prefWidth="530.0" BorderPane.alignment="CENTER" />
</bottom>
<top>
<TitledPane animated="false" text="Build Control System" BorderPane.alignment="CENTER">
<content>
<AnchorPane minHeight="0.0" minWidth="0.0" prefHeight="0.0" prefWidth="598.0" />
</content>
</TitledPane>
</top>
</BorderPane>
