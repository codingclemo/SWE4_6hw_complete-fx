package com.sammereyer.helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlbumTableGenerator {
	public static TableView<DataTableModelAlbum> generateAlbumTable() {
		TableView<DataTableModelAlbum> table = new TableView<>();
		table.setEditable(true);

		TableColumn<DataTableModelAlbum, Integer> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<DataTableModelAlbum, String> teamCol = new TableColumn<>("Team");
		teamCol.setCellValueFactory(new PropertyValueFactory<>("team"));
		
		TableColumn<DataTableModelAlbum, String> nameCol = new TableColumn<>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<DataTableModelAlbum, Integer> nrOfTicketsCol = new TableColumn<>("#");
		nrOfTicketsCol.setCellValueFactory(new PropertyValueFactory<>("numberOfTickets"));

		table.getColumns().addAll(idCol, teamCol, nameCol, nrOfTicketsCol);

		ObservableList<DataTableModelAlbum> data = FXCollections.observableArrayList(
				new DataTableModelAlbum(1, "Jacob", "Smith", 4), new DataTableModelAlbum(2, "Isabella", "Johnson", 3),
				new DataTableModelAlbum(3, "Ethan", "Williams", 5), new DataTableModelAlbum(4, "Emma", "Jones", 1),
				new DataTableModelAlbum(5, "Michael", "Brown", 4));

		table.setItems(data);
		return table;
	}
}
