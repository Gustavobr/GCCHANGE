class RepoChanges {
	getRepoChanges(button) {
		let filter = new Filter(document.getElementById("since").value,
			document.getElementById("until").value);

		gctoolsUtil.appendSpinner(button);

		gctoolsUtil.postJson(
			"repoChangesResult",
			filter,
			"html",
			(response) => $("#repoChangesResult").html(response),
			(error) => console.error("RepoChanges.getRepoChanges fail. Error:", error),
			() => gctoolsUtil.removeSpinner(button)
		);
	}
}