<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Even Numbers From One to N</title>
</head>
<body>
	<form>
		<input type="text" name="num"/>
		<input type="submit"/>
		<?php
			if (isset($_GET['num'])) {
				$numbers;
				for ($i = 1; $i <= intval($_GET['num']); $i++) {
					if ($i % 2 == 0) {
						$numbers[] = $i;
					}
				}
				
				echo "<p>" . implode(" ", $numbers) . "</p>";
			}			
		?>
	</form>
</body>
</html>