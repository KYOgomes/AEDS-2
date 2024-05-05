/*** Classe Jogadores
 * @author Caio Gomes Alcantara Glória - 763989
 * @version 04/05/2024
 */

#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
#include <time.h>

#define TAM 200

// Contagem de comparações
int count = 0;

// Atributos
typedef struct Personagem
{
  char id[TAM];
  char name[TAM];
  char alternateNames[TAM];
  char house[TAM];
  char ancestry[TAM];
  char species[TAM];
  char patronus[TAM];
  char hogwartsStaff[TAM]; 
  char hogwartsStudent[TAM]; 
  char actorName[TAM];
  char alive[TAM];
  char alternateActor[TAM];
  char dateOfBirth[TAM];
  int yearOfBirth;
  char eyeColour[TAM];
  char gender[TAM];
  char hairColour[TAM];
  char wizard[TAM]; 
} Personagem;

// Construtores
Personagem newPersonagem(char id[], char name[], char alternateNames[], char house[], char ancestry[], char species[],
                         char patronus[], char hogwartsStaff[], char hogwartsStudent[], char actorName[],
                         char alive[], char alternateActor[], char dateOfBirth[], int yearOfBirth,
                         char eyeColour[], char gender[], char hairColour[], char wizard[])
{
  Personagem p;
  strcpy(p.id, id);
  strcpy(p.name, name);
  strcpy(p.alternateNames, alternateNames);
  strcpy(p.house, house);
  strcpy(p.ancestry, ancestry);
  strcpy(p.species, species);
  strcpy(p.patronus, patronus);
  strcpy(p.hogwartsStaff, hogwartsStaff);
  strcpy(p.hogwartsStudent, hogwartsStudent);
  strcpy(p.actorName, actorName);
  strcpy(p.alive, alive);
  strcpy(p.alternateActor, alternateActor);
  strcpy(p.dateOfBirth, dateOfBirth);
  p.yearOfBirth = yearOfBirth;
  strcpy(p.eyeColour, eyeColour);
  strcpy(p.gender, gender);
  strcpy(p.hairColour, hairColour);
  strcpy(p.wizard, wizard);
  return p;
}

Personagem newPersonagemDefault()
{
  Personagem p;
  strcpy(p.id, "");
  strcpy(p.name, "");
  strcpy(p.alternateNames, "");
  strcpy(p.house, "");
  strcpy(p.ancestry, "");
  strcpy(p.species, "");
  strcpy(p.patronus, "");
  strcpy(p.hogwartsStaff, "");
  strcpy(p.hogwartsStudent, "");
  strcpy(p.actorName, "");
  strcpy(p.alive, "");
  strcpy(p.alternateActor, "");
  strcpy(p.dateOfBirth, "");
  p.yearOfBirth = 0;
  strcpy(p.eyeColour, "");
  strcpy(p.gender, "");
  strcpy(p.hairColour, "");
  strcpy(p.wizard, "");
  return p;
}

// Getters
char* getId(Personagem *p){
    return p->id;
}

char* getName(Personagem *p){
    return p->name;
}

char* getAlternate_names(Personagem *p){
    return p->alternateNames;
}

char* getHouse(Personagem *p){
    return p->house;
}

char* getAncestry(Personagem *p){
    return p->ancestry;
}

char* getSpecies(Personagem *p){
    return p->species;
}

char* getPatronus(Personagem *p){
    return p->patronus;
}

char* getHogwartsStaff(Personagem *p){
    return strcmp(p->hogwartsStaff, "VERDADEIRO") == 0 ? "true" : "false";
}

char* getHogwartsStudent(Personagem *p){
    return strcmp(p->hogwartsStudent, "VERDADEIRO") == 0 ? "true" : "false";
}

char* getActorName(Personagem *p){
    return p->actorName;
}

char* getAlive(Personagem *p){
    return strcmp(p->alive, "VERDADEIRO") == 0 ? "true" : "false";
}

char* getAlternateActor(Personagem *p){
    return p->alternateActor;
}

char* getDateOfBirth(Personagem *p){
    return p->dateOfBirth;
}

int getYearOfBirth(Personagem *p){
    return p->yearOfBirth;
}

char* getEyeColour(Personagem *p){
    return p->eyeColour;
}

char* getGender(Personagem *p){
    return p->gender;
}

char* getHairColor(Personagem *p){
    return p->hairColour;
}

char* getWizard(Personagem *p){
    return strcmp(p->wizard, "VERDADEIRO") == 0 ? "true" : "false";
}

// Setters
void setId(char *id, Personagem *p){
    strcpy(p->id, id);
}

void setName(char *name, Personagem *p){
    strcpy(p->name, name);
}

void setAlternate_names(char *alternateNames, Personagem *p){
    strcpy(p->alternateNames, alternateNames);
}

void setHouse(char *house, Personagem *p){
    strcpy(p->house, house);
}

void setAncestry(char *species, Personagem *p){
    strcpy(p->species, species);
}

void setSpecies(char *species, Personagem *p){
    strcpy(p->species, species);
}

void setPatronus(char *patronus, Personagem *p){
    strcpy(p->patronus, patronus);
}

void setHogwartsStaff(char *hogwartsStaff, Personagem *p){
    strcpy(p->hogwartsStaff, hogwartsStaff);
}

void setHogwartsStudent(char *hogwartsStudent, Personagem *p){
    strcpy(p->hogwartsStaff, hogwartsStudent);
}

void setActorName(char *actorName, Personagem *p){
    strcpy(p->actorName, actorName);
}

void setAlive(char *alive, Personagem *p){
    strcpy(p->alive, alive);
}

void setAlternateActor(char *alternateActor, Personagem *p){
    strcpy(p->alternateActor, alternateActor);
}

void setDateOfBirth(char *dateOfBirth, Personagem *p){
    strcpy(p->dateOfBirth, dateOfBirth);
}

void setYearOfBirth(int yearOfBirth, Personagem *p){
    p->yearOfBirth = yearOfBirth;
}

void setEyeColour(char *eyeColour, Personagem *p){
    strcpy(p->eyeColour, eyeColour);
}

void setGender(char *gender, Personagem *p){
    strcpy(p->gender, gender);
}

void setHairColor(char *hairColor, Personagem *p){
    strcpy(p->hairColour, hairColor);
}

void setWizard(char *wizard, Personagem *p){
    strcpy(p->wizard, wizard);
}

// Função de leitura
char **ler(char line[])
{
  int tam_line = strlen(line);
  int start = 0;
  int count_campos = 0;
  char **campos = malloc(18 * sizeof(char *));
  for (int i = 0; i < 18; i++)
  {
    campos[i] = malloc(TAM * sizeof(char));
  }
  for (int i = 0; i < tam_line; i++)
  {
    if (line[i] == ';' && line[i - 1] == ';')
    {
      strcpy(campos[count_campos], "");
      start = i + 1;
      count_campos++;
    }
    else if (line[i] == ';')
    {
      strncpy(campos[count_campos], line + start, i - start);
      campos[count_campos][i - start] = '\0';
      start = i + 1;
      count_campos++;
    }
  }
  strncpy(campos[17], line + start, tam_line - start - 1);
  return campos;
}

void imprimir(Personagem *p)
{
  printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n",
         p->id, p->name, p->alternateNames, p->house, p->ancestry, p->species, p->patronus,
         strcmp(p->hogwartsStaff, "VERDADEIRO") == 0 ? "true" : "false",
         strcmp(p->hogwartsStudent, "VERDADEIRO") == 0 ? "true" : "false",
         p->actorName, strcmp(p->alive, "VERDADEIRO") == 0 ? "true" : "false",
         p->alternateActor, p->dateOfBirth, p->yearOfBirth, p->eyeColour, p->gender, p->hairColour,
         strcmp(p->wizard, "VERDADEIRO") == 0 ? "true" : "false");
}

void preencheVetor(Personagem arr[], char ids[][TAM])
{
  FILE *file;
  char line[500];
  if ((file = fopen("/tmp/characters.csv", "r")) != NULL)
  {
    int i = 0;
    int tamList;
    fgets(line, 500, file);
    while (fgets(line, 500, file) != NULL)
    {
      char **atributos = ler(line);
      for (int i = 0; atributos[2][i] != '\0'; i++)
      {
        if (atributos[2][i] == '[')
        {
          atributos[2][i] = '{';
        }
        else if (atributos[2][i] == '\'')
        {
          for (int j = i; atributos[2][j] != '\0'; j++)
          {
            atributos[2][j] = atributos[2][j + 1];
          }
        }
      }
      tamList = strlen(atributos[2]);
      atributos[2][tamList - 1] = '}';
      for (int k = 0; k < 27; k++)
      {
        if (strcmp(ids[k], atributos[0]) == 0)
        {
          arr[i] = newPersonagem(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4],
                                  atributos[5], atributos[6], atributos[7], atributos[8], atributos[9], atributos[10], atributos[11],
                                  atributos[12], atoi(atributos[13]), atributos[14], atributos[15], atributos[16], atributos[17]);
          i++;
        }
      }
      free(atributos); // Liberando memória alocada para atributos
    }
    fclose(file);
  }
  else
  {
    printf("Não foi possivel ler o arquivo");
  }
}

void swap(Personagem arr[], int a, int b) {
    Personagem temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

void insertionSort(Personagem arr[], int n) {
    int i, j;
    Personagem chave;

    for (i = 1; i < n; i++) {
        chave = arr[i];
        j = i - 1;

        while (j >= 0 && strcmp(arr[j].name, chave.name) > 0) {
            arr[j + 1] =arr[j];
            j = j - 1;
        }
        arr[j + 1] = chave;
    }
}

bool PesquisaBinaria(Personagem arr[], char nome[])
{
  int dir = 26;
  int esq = 0;
  int meio;
  bool resp = false;
  while (esq <= dir)
  {
    meio = (esq + dir) / 2;
    count++; // Incrementa o contador a cada comparação
    if (strcmp(arr[meio].name, nome) == 0)
    {
      resp = true;
      esq = dir + 1;
    }
    else if (strcmp(arr[meio].name, nome) > 0)
    {
      dir = meio - 1;
    }
    else
    {
      esq = meio + 1;
    }
  }
  return resp;
}

void selectionSort(Personagem arr[], int n) {
    int i, j, min_idx;
    Personagem temp;

    // Loop para percorrer todos os elementos do array
    for (i = 0; i < n - 1; i++) {
        // Encontra o índice do menor elemento restante
        min_idx = i;
        for (j = i + 1; j < n; j++)
            if (strcmp(arr[j].name, arr[min_idx].name) < 0)
                min_idx = j;

        // Troca o elemento mínimo encontrado com o primeiro elemento não ordenado
        temp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = temp;
    }
}


int main()
{
  clock_t inicio = clock();
  char id[TAM];
  char ids[30][TAM];
  int i = 0;
  char name[TAM];
  char aux[TAM];
  scanf("%s", id);
  while (strcmp(id, "FIM") != 0)
  {
    strcpy(ids[i], id);
    i++;
    scanf("%s", id);
  }
  Personagem arr[27];
  preencheVetor(arr, ids);
  insertionSort(arr, 27);
  clock_t fim = clock();
  double tempoExecucao = ((double)(fim - inicio)) / CLOCKS_PER_SEC; // Tempo em segundos
  FILE *log;
  if ((log = fopen("matricula_binaria.txt", "w")) != NULL)
  {
    fprintf(log, "780371\t%d\t%f", count, tempoExecucao);
    fclose(log);
  }
  else
  {
    printf("Erro ao abrir arquivo de Log!");
  }
  bool find;
  scanf("%99[^\n]%*c", aux);
  //-----------------------//
  scanf("%99[^\n]%*c", name);
  name[strcspn(name, "\r")] = '\0';
  while (strcmp(name, "FIM") != 0)
  {
    find = PesquisaBinaria(arr, name);
    if (find == true)
    {
      printf("SIM\n");
    }
    else
    {
      printf("NAO\n");
    }
    scanf("%99[^\n]%*c", name);
    name[strcspn(name, "\r")] = '\0';
  }
}