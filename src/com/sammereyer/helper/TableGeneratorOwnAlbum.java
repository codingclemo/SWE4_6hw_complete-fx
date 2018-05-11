package com.sammereyer.helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableGeneratorOwnAlbum {
	public static TableView<DataTableModelOwnAlbum> generateOwnAlbumTable() {
		TableView<DataTableModelOwnAlbum> table = new TableView<>();
		table.setEditable(true);

		TableColumn<DataTableModelOwnAlbum, Integer> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<DataTableModelOwnAlbum, String> teamCol = new TableColumn<>("Team");
		teamCol.setCellValueFactory(new PropertyValueFactory<>("team"));
		
		TableColumn<DataTableModelOwnAlbum, String> nameCol = new TableColumn<>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<DataTableModelOwnAlbum, Integer> nrOfTicketsCol = new TableColumn<>("#");
		nrOfTicketsCol.setCellValueFactory(new PropertyValueFactory<>("numberOfTickets"));

		table.getColumns().addAll(idCol, teamCol, nameCol, nrOfTicketsCol);

		ObservableList<DataTableModelOwnAlbum> data = FXCollections.observableArrayList(
				new DataTableModelOwnAlbum(1, "Jacob", "Smith", 4), new DataTableModelOwnAlbum(2, "Isabella", "Johnson", 3),
				new DataTableModelOwnAlbum(3, "Ethan", "Williams", 5), new DataTableModelOwnAlbum(4, "Emma", "Jones", 1),
				new DataTableModelOwnAlbum(5, "Michael", "Brown", 4));

		table.setItems(data);
		return table;
	}
}
