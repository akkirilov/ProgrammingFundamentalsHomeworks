<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Odd Numbers From One to N</title>
</head>
<body>
	<form>
		<input type="text" name="num"/>
		<input type="submit"/>
		<?php
			if (isset($_GET['num'])) {
				$numbers;
				for ($i = intval($_GET['num']); $i > 0; $i--) {
					if ($i % 2 == 1) {
						$numbers[] = $i;
					}
				}
				
				echo "<p>" . implode(" ", $numbers) . "</p>";
			}			
		?>
	</form>
</body>
</html>