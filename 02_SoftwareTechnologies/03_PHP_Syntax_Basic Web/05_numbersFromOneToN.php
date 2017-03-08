<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Numbers From One to N</title>
</head>
<body>
	<form>
		<input type="text" name="num"/>
		<input type="submit"/>
		<?php
			if (isset($_GET['num'])) {
				$numbers;
				for ($i = 1; $i <= intval($_GET['num']); $i++) {
					$numbers[] = $i;
				}
				
				echo "<p>" . implode(" ", $numbers) . "</p>";
			}			
		?>
	</form>
</body>
</html>