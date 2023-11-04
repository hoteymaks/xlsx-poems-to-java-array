# xlsx-poems-to-java-array
Extract poems data from Excel


## Description
Easily turn your poems Excel file to ArrayList. This repository can be considered as a sequel for <link href="https://github.com/hoteymaks/docx-poems-to-xlsx-sheets">my Word poems file to Excel sheets utility</link>.


## How to use
<b>Using SheetsToArrayList file</b>
1. Download yourself a `SheetsToArrayList.java` file from `src` folder
2. If you don't have a class to structurize the poems by their title, author and content, consider downloading `Content.java` class as well
3. Call `getPoems("your-file-name.xlsx")` whenever you need to extract poem data from Excel


<b>Cloning the whole project</b>
1. Clone the project to your IDE (e.g. for IntellJ IDEA: "File" - "New" - "Project from Version Control" - "Repository URL" - paste `https://github.com/hoteymaks/xlsx-poems-to-java-array.git` in URL field)
2. Place your .xlsx file of poems in the project directory
3. Open `SheetsToArrayList.java` from `src` folder
4. Change file name on line 27 from `sample-poems.xlsx` to your own
5. Now you have an ArrayList of poems


## How it works
- Utility takes sheet first column as an author name
- If provided, sheet second column as a poem title
- Paragraphs of text provided in the sheet's third column as the poem itself

Collected data form class objects with the mentioned content respectively.


## Sample document
Repository contains a sample Excel file `sample-poems.xlsx`.
