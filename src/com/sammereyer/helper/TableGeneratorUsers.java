package com.sammereyer.helper;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableGeneratorUsers {
	public static TableView<DataTableModelUsers> generateUserTable() {
		TableView<DataTableModelUsers> table = new TableView<>();
		table.setEditable(true);

		TableColumn<DataTableModelUsers, Integer> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<DataTableModelUsers, String> usernameCol = new TableColumn<>("Username");
		usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

		TableColumn<DataTableModelUsers, String> countryCol = new TableColumn<>("Country");
		countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

		TableColumn<DataTableModelUsers, String> regionCol = new TableColumn<>("Region");
		regionCol.setCellValueFactory(new PropertyValueFactory<>("region"));

		TableColumn<DataTableModelUsers, Integer> stickersTotalCol = new TableColumn<>("Stickers Total");
		stickersTotalCol.setCellValueFactory(new PropertyValueFactory<>("stickersTotal"));

		TableColumn<DataTableModelUsers, Integer> stickersDuplicateCol = new TableColumn<>("Stickers Duplicate");
		stickersDuplicateCol.setCellValueFactory(new PropertyValueFactory<>("stickersDuplicate"));

		TableColumn<DataTableModelUsers, Integer> stickersIntersectCol = new TableColumn<>("Stickers Intersect");
		stickersIntersectCol.setCellValueFactory(new PropertyValueFactory<>("stickersIntersect"));

		table.getColumns().addAll(idCol, usernameCol, countryCol, regionCol, stickersTotalCol, stickersDuplicateCol,
				stickersIntersectCol);

		ObservableList<DataTableModelUsers> data = FXCollections.observableArrayList(
				new DataTableModelUsers(1, "Clemens", "Austria", "Upperaustria", 10, 3, 7),
				new DataTableModelUsers(2, "Georg", "Austria", "Vienna", 5, 4, 1),
				new DataTableModelUsers(3, "Tobias", "Austria", "Upperaustria", 12, 11, 1),
				new DataTableModelUsers(4, "Hannes", "Switzerland", "Zurich", 24, 12, 12),
				new DataTableModelUsers(4, "Hannes", "Switzerland", "Zurich", 24, 12, 12),
				new DataTableModelUsers(5, "HANS", "Germany", "Berlin", 4, 2, 2));
		

		table.setItems(data);
		
		// dynamic height if needed
		//table.setFixedCellSize(25);
		//table.prefHeightProperty().bind(Bindings.size(table.getItems()).multiply(table.getFixedCellSize()).add(55));
		
		return table;
	}
}
