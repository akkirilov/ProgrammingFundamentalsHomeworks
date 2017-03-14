<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Numbers From N to One</title>
</head>
<body>
	<form>
		<input type="text" name="num"/>
		<input type="submit"/>
		<?php
			if (isset($_GET['num'])) {
				$numbers;
				for ($i = intval($_GET['num']); $i > 0; $i--) {
					$numbers[] = $i;
				}
				
				echo "<p>" . implode(" ", $numbers) . "</p>";
			}			
		?>
	</form>
</body>
</html>