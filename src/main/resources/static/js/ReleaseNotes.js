class ReleaseNotes {
	releaseNotesResult(button) {
		let filter = new Filter(null, null, $("#tagBase").val(), $("#tagHead").val());

		gctoolsUtil.appendSpinner(button);

		gctoolsUtil.postJson(
			"releaseNotesResult",
			filter,
			"html",
			(response) => $("#releaseNotesResult").html(response),
			(error) => console.error("ReleaseNotes.getReleaseNotesResult fail. Error:", error),
			() => gctoolsUtil.removeSpinner(button)
		);
	}
}